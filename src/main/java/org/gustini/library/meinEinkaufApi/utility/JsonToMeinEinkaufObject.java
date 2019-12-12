/**
 * 
 */
package org.gustini.library.meinEinkaufApi.utility;

import java.util.ArrayList;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.get.Consignment;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.get.Order;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.get.ProcessingStateHistory;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.get.TrackingResponse;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.response.ResponseErrorObject;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.response.ResponseObject;
import org.gustini.library.meinEinkaufApi.objects.enums.Carrier;
import org.gustini.library.meinEinkaufApi.objects.enums.ProcessingState;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Gustini GmbH (2019) Creation: 09.07.2019 gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.utility
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *
 */
public class JsonToMeinEinkaufObject
{
	/**
	 * 
	 * Description:
	 * 
	 * @param resultJsonString
	 * @return Creation: 09.07.2019 by mst
	 */
	public static ResponseObject getResponseObjectFromJsonString(String resultJsonString)
	{
		ResponseObject responseObject = null;
		if (JsonBuilder.isJSONValid(resultJsonString))
		{
			JSONObject jo = JsonBuilder.getJsonObjectFromJsonString(resultJsonString);
			if (isValidResponseValueFromMeinEinkauf(jo))
			{
				boolean success = jo.getBoolean("success");
				ArrayList<ResponseErrorObject> errorsArrayList = new ArrayList<>();
				JSONArray joArray = jo.getJSONArray("errors");
				// Wenn Fehler vorhanden sind erstelle ResponseErrorObjects
				for (Object errorJsonObject : joArray)
				{
					if (errorJsonObject instanceof JSONObject)
					{
						String code = ((JSONObject) errorJsonObject).getString("code");
						String message = ((JSONObject) errorJsonObject).getString("message");
						String properties = "";
						if (((JSONObject) errorJsonObject).has("property"))
						{
							properties = ((JSONObject) errorJsonObject).getString("property");
						}
						ResponseErrorObject errorObject = new ResponseErrorObject(code, message, properties);
						errorsArrayList.add(errorObject);
					}

				}
				responseObject = new ResponseObject(success, errorsArrayList.toArray(new ResponseErrorObject[0]));
				// Prüfe ob es Orders gibt
				if (jo.has("orders"))
				{
					boolean hasValues = true;
					int limit = jo.getInt("limit");
					int count = jo.getInt("count");

					int offset = jo.getInt("offset");
					responseObject.setOffset(offset);
					responseObject.setLimit(limit);
					responseObject.setCount(count);
					responseObject.setOrdersJSONArray(jo.getJSONArray("orders"));
					responseObject.setHasValues(hasValues);
				} else if (jo.has("order"))
				{
					/*
					 * Einzelne Order angefragt und entsprechent interpretiert
					 */
					JSONArray jsonArray = new JSONArray();
					jsonArray.put(jo.get("order"));
					responseObject.setHasValues(true);
					responseObject.setCount(1);
					responseObject.setOrdersJSONArray(jsonArray);

				} else

				{
					responseObject.setHasValues(false);
				}

			} else
			{
				// Kein gültiges Response-Objekt - erstelle manuell eines
				boolean success = false;
				ResponseErrorObject error = new ResponseErrorObject("-1",
							"Response enthält keine gültiges JSON-Objekt: \r\n"
										+ resultJsonString,
							"Dieses Error-Objekt wurde vom Programm generiert.");
				error.setJsonValue(resultJsonString);
				ResponseErrorObject[] errors =
				{ error };
				responseObject = new ResponseObject(success, errors);
			}

			return responseObject;
		} else
		{
			boolean success = false;
			ResponseErrorObject error = new ResponseErrorObject("-2", "Response enthält keine gültiges JSON: \r\n"
						+ resultJsonString, "");
			ResponseErrorObject[] errors =
			{ error };
			responseObject = new ResponseObject(success, errors);
			return responseObject;
		}

	}

	/**
	 * 
	 * Description: Prüft ob die Elemente der ersten Ebene des JSONObjekts vorhanden
	 * sind.
	 * 
	 * @param jo
	 * @return Creation: 09.07.2019 by mst
	 */
	protected static boolean isValidResponseValueFromMeinEinkauf(JSONObject jo)
	{
		String[] neededKeys =
		{ "success", "errors" };
		// Set<String> avaibleKeySet = jo.keySet();
		boolean valid = true;
		for (String key : neededKeys)
		{
			valid = valid && jo.has(key);
		}
		return valid;
	}

	/**
	 * 
	 * Description:Create OrderArray (GET) from JSONArray
	 * 
	 * @param orderJsonArray Creation: 09.07.2019 by mst
	 */
	public static Order[] getOrderResponsesFromJsonarray(JSONArray orderJsonArray)
	{
		ArrayList<Order> joArrayList = new ArrayList<>();
		for (Object object : orderJsonArray)
		{
			if (object instanceof JSONObject)
			{
				JSONObject jo = (JSONObject) object;
				int id = jo.getInt("id");
				String created = jo.getString("created");
				String orderNumber = jo.getString("orderNumber");
				String orderDate = jo.getString("orderDate");
				String processingStateValueFromJson = jo.getString("processingState");
				ProcessingState processingState = ProcessingState.valueOf(processingStateValueFromJson);

				JSONArray processingStateJsonArray = jo.getJSONArray("processingStateHistory");
				ArrayList<ProcessingStateHistory> processingStateHistories = new ArrayList<>();
				for (Object processingStateObject : processingStateJsonArray)
				{
					if (processingStateObject instanceof JSONObject)
					{
						JSONObject processingStateJsonObject = (JSONObject) processingStateObject;
						String state, changed;
						state = processingStateJsonObject.getString("state");
						changed = processingStateJsonObject.getString("changed");
						ProcessingStateHistory stateHistory = new ProcessingStateHistory(state, changed);
						processingStateHistories.add(stateHistory);
					}
				}
				ProcessingStateHistory[] processingStateHistory = processingStateHistories
							.toArray(new ProcessingStateHistory[0]);
				String processingStateChanged = jo.getString("processingStateChanged");
				/*
				 * Eine Auflistung der einzelnen Sendungen der Bestellung mit zusätzlichen
				 * Informationen zu dieser Sendung, erst vorhanden, wenn processingState
				 * "exported" oder "exported_partially"
				 */
				JSONArray consignmentsJsonArray = jo.getJSONArray("consignments");
				ArrayList<Consignment> consignmentsArrayList = new ArrayList<>();
				for (Object consignmentObject : consignmentsJsonArray)
				{
					
					if (consignmentObject instanceof JSONObject)
					{
						/**
						 * In seltenen Fällen, wenn eine Sendung den Status "Problem" hat, können ConsignmentObjekte "null" enthalten -> In dem Fall wird die Info nicht übernommen.
						 */
						if (((JSONObject) consignmentObject).isNull("externalId") == false)
						{

							String externalId = ((JSONObject) consignmentObject).getString("externalId");
							// if (id == 11946)
							// System.out.println("STOP");
							ArrayList<TrackingResponse> gasLabelsArrayList = new ArrayList<>();
							JSONObject consignmentJSONObject = (JSONObject) consignmentObject;
							if (consignmentJSONObject.isNull("gasLabels") == false)
							{
								JSONArray gasLabelsJsonArray = consignmentJSONObject.getJSONArray("gasLabels");
								for (Object gasLabelJSONObject : gasLabelsJsonArray)
								{
									if (gasLabelJSONObject instanceof JSONObject)
									{
										String gasCarrier, gasTrackingNumber;
										gasCarrier = ((JSONObject) gasLabelJSONObject).getString("carrier");
										gasTrackingNumber = ((JSONObject) gasLabelJSONObject)
													.getString("trackingNumber");
										TrackingResponse gasLabel = new TrackingResponse(Carrier.valueOf(gasCarrier),
													gasTrackingNumber);
										gasLabelsArrayList.add(gasLabel);
									}
								}
//                              not used and for this reason commented:
//                            if (consignmentJSONObject.isNull("gas") == false)
//                            {
//                                JSONObject gasJSONObject = consignmentJSONObject.getJSONObject("gas");
//                            }
								if (!consignmentJSONObject.isNull("tracking"))
								{
									JSONObject trackingJsonObject = consignmentJSONObject.getJSONObject("tracking");
									String carrierTracking, trackingNumber;
									carrierTracking = trackingJsonObject.getString("carrier");
									trackingNumber = trackingJsonObject.getString("trackingNumber");

									TrackingResponse trackingResponse = new TrackingResponse(
												Carrier.valueOf(carrierTracking), trackingNumber);
									Consignment co = new Consignment(trackingResponse,
												gasLabelsArrayList.toArray(new TrackingResponse[0]));
									co.setExternalId(externalId);
									consignmentsArrayList.add(co);
								}
							}
						}
					}
				}

				Consignment[] consignments = consignmentsArrayList.toArray(new Consignment[0]);
				Order order = new Order(id, created, orderNumber, orderDate, processingState, processingStateHistory,
							processingStateChanged, consignments);
				joArrayList.add(order);
			}
		}

		return joArrayList.toArray(new Order[0]);

	}

}
