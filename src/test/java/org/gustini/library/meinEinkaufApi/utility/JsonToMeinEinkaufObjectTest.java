package org.gustini.library.meinEinkaufApi.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.get.Order;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.response.ResponseObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class JsonToMeinEinkaufObjectTest
{
    private final String fullOrderResponseString = "{\"orders\":[{\"id\":11289,\"created\":\"2019-07-09T10:37:09+02:00\",\"orderNumber\":\"940108485\","
                + "\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\""
                + ":\"2019-07-09T10:37:09+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\","
                + "\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:05+02:00\"},{\"state\":\"exported\","
                + "\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1281,\""
                + "tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\""
                + ":\"996006631900000001\"}}]},{\"id\":11293,\"created\":\"2019-07-09T10:37:09+02:00\",\"orderNumber\":\"940108683\",\"orderDate\":\"2019"
                + "-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:09+02:00\"},{"
                + "\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:0"
                + "0\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:06+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:0"
                + "0\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1285,\"tracking\":{\"carrier\":\"swisspost\","
                + "\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11"
                + "301,\"created\":\"2019-07-09T10:37:09+02:00\",\"orderNumber\":\"940108641\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exporte"
                + "d\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:10+02:00\"},{\"state\":\"arrival_assumed\",\"change"
                + "d\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:08+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1293,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11305,\"created\":\"2019-07-09T10:37:10+02:00\",\"orderNumber\":\"940108740\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:10+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:09+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1297,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11309,\"created\":\"2019-07-09T10:37:10+02:00\",\"orderNumber\":\"940108542\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:10+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:11+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1301,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11317,\"created\":\"2019-07-09T10:37:11+02:00\",\"orderNumber\":\"940108500\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:11+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:13+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1309,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11321,\"created\":\"2019-07-09T10:37:11+02:00\",\"orderNumber\":\"940108568\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:11+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:15+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1313,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11325,\"created\":\"2019-07-09T10:37:11+02:00\",\"orderNumber\":\"940108469\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:11+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:16+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1317,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11329,\"created\":\"2019-07-09T10:37:12+02:00\",\"orderNumber\":\"940108667\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:12+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:17+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1321,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11337,\"created\":\"2019-07-09T10:37:12+02:00\",\"orderNumber\":\"940108526\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:12+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:20+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1329,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11341,\"created\":\"2019-07-09T10:37:13+02:00\",\"orderNumber\":\"940108625\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:13+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:21+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1333,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11345,\"created\":\"2019-07-09T10:37:13+02:00\",\"orderNumber\":\"940108724\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:13+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:22+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1337,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11349,\"created\":\"2019-07-09T10:37:13+02:00\",\"orderNumber\":\"940108609\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:13+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:24+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1341,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11357,\"created\":\"2019-07-09T10:37:14+02:00\",\"orderNumber\":\"940108493\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:14+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:27+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1349,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11361,\"created\":\"2019-07-09T10:37:14+02:00\",\"orderNumber\":\"940108592\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:14+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:28+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1353,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11365,\"created\":\"2019-07-09T10:37:15+02:00\",\"orderNumber\":\"940108691\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:15+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:30+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1357,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11369,\"created\":\"2019-07-09T10:37:15+02:00\",\"orderNumber\":\"940108451\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:15+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:31+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1361,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11373,\"created\":\"2019-07-09T10:37:15+02:00\",\"orderNumber\":\"940108550\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:15+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:32+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1365,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11381,\"created\":\"2019-07-09T10:37:16+02:00\",\"orderNumber\":\"940108576\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:16+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:35+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1373,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11385,\"created\":\"2019-07-09T10:37:16+02:00\",\"orderNumber\":\"940108477\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:16+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:36+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1377,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11389,\"created\":\"2019-07-09T10:37:17+02:00\",\"orderNumber\":\"940108675\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:17+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:38+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1381,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11397,\"created\":\"2019-07-09T10:37:17+02:00\",\"orderNumber\":\"940108633\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:17+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:40+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1389,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11401,\"created\":\"2019-07-09T10:37:18+02:00\",\"orderNumber\":\"940108732\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:18+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:41+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1393,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11405,\"created\":\"2019-07-09T10:37:18+02:00\",\"orderNumber\":\"940108534\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:18+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:43+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1397,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11413,\"created\":\"2019-07-09T10:37:19+02:00\",\"orderNumber\":\"940108518\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:19+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:45+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1405,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11417,\"created\":\"2019-07-09T10:37:19+02:00\",\"orderNumber\":\"940108716\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:19+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:46+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1409,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11421,\"created\":\"2019-07-09T10:37:19+02:00\",\"orderNumber\":\"940108617\",\"orderDate\":\"2019-06-17\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:19+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:48+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1413,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11297,\"created\":\"2019-07-09T10:37:09+02:00\",\"orderNumber\":\"940108443\",\"orderDate\":\"2019-06-14\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:09+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:07+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1289,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11313,\"created\":\"2019-07-09T10:37:10+02:00\",\"orderNumber\":\"940108401\",\"orderDate\":\"2019-06-14\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:11+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:12+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1305,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11333,\"created\":\"2019-07-09T10:37:12+02:00\",\"orderNumber\":\"940108427\",\"orderDate\":\"2019-06-14\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:12+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:19+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1325,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11393,\"created\":\"2019-07-09T10:37:17+02:00\",\"orderNumber\":\"940108435\",\"orderDate\":\"2019-06-14\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:17+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:39+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1385,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11409,\"created\":\"2019-07-09T10:37:18+02:00\",\"orderNumber\":\"940108419\",\"orderDate\":\"2019-06-14\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:18+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:44+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1401,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11285,\"created\":\"2019-07-09T10:37:08+02:00\",\"orderNumber\":\"940108386\",\"orderDate\":\"2019-06-13\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:08+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:03+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1277,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11353,\"created\":\"2019-07-09T10:37:14+02:00\",\"orderNumber\":\"940108394\",\"orderDate\":\"2019-06-13\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:14+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:25+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1345,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11377,\"created\":\"2019-07-09T10:37:16+02:00\",\"orderNumber\":\"940108378\",\"orderDate\":\"2019-06-13\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:37:16+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:34+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1369,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]},{\"id\":11281,\"created\":\"2019-07-09T10:36:10+02:00\",\"orderNumber\":\"123456789\",\"orderDate\":\"2019-06-11\",\"processingState\":\"exported\",\"processingStateHistory\":[{\"state\":\"open\",\"changed\":\"2019-07-09T10:36:10+02:00\"},{\"state\":\"arrival_assumed\",\"changed\":\"2019-07-09T10:45:02+02:00\"},{\"state\":\"arrived\",\"changed\":\"2019-07-09T11:00:01+02:00\"},{\"state\":\"verified\",\"changed\":\"2019-07-09T11:15:01+02:00\"},{\"state\":\"exported\",\"changed\":\"2019-07-09T11:30:02+02:00\"}],\"processingStateChanged\":\"2019-07-09T11:30:02+02:00\",\"consignments\":[{\"id\":1273,\"tracking\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"},\"gas\":{\"carrier\":\"swisspost\",\"trackingNumber\":\"996006631900000001\"}}]}],\"count\":36,\"limit\":50,\"offset\":0,\"errors\":[],\"success\":true}\r\n"; 
                
    private final String failedRequestJsonResponse="{\"success\":false,\"errors\":[{\"code\":\"E0000\",\"message\":\"ApiKey is missing\"}]}\r\n";
    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    
    @Test
    public void checkFullOrderResponseStringForValidity() throws Exception
    {
        assertTrue(JsonBuilder.isJSONValid(fullOrderResponseString));
    }
    @Test
    public void testGetResponseObjectFromJsonString() throws Exception
    {
        ResponseObject roFull = JsonToMeinEinkaufObject.getResponseObjectFromJsonString(fullOrderResponseString);
        ResponseObject roError = JsonToMeinEinkaufObject.getResponseObjectFromJsonString(failedRequestJsonResponse);
        assertTrue(roFull.hasValues());
        assertFalse(roError.hasValues());
    }

    @Test
    public void testIsValidResponseValueFromMeinEinkauf() throws Exception
    {
        JSONObject joFullResponse = new JSONObject(fullOrderResponseString);
        JSONObject joErrorResponse = new JSONObject(failedRequestJsonResponse);
        assertTrue(JsonToMeinEinkaufObject.isValidResponseValueFromMeinEinkauf(joFullResponse));
        assertTrue(JsonToMeinEinkaufObject.isValidResponseValueFromMeinEinkauf(joErrorResponse));
        
    }

    @Test
    public void testGetOrderResponsesFromJsonarray() throws Exception
    {
        JSONObject joFullResponse = new JSONObject(fullOrderResponseString);
        JSONArray ordersJSONArray = joFullResponse.getJSONArray("orders");
        Order[] orders = JsonToMeinEinkaufObject.getOrderResponsesFromJsonarray(ordersJSONArray);
        assertTrue(orders.length == 36);
    }

}
