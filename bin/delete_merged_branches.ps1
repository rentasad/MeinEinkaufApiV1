git branch --merged | ForEach-Object {
    $branchName = $_.Trim()
    if ($branchName -ne 'DEV' -and $branchName -ne '* DEV') {
        git branch -d $branchName
    }
}