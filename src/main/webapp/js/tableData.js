console.log('tableData.js');

let saveDataButtonObj = document.getElementById('saveDataButton');

/* 當使用者按下『儲存勾選列之背景顏色』按鈕 時，執行這段程式 */
saveDataButtonObj.addEventListener('click', function(event) {
    var selectCheckboxArray = jQuery('#CustomerTable input:checkbox[name="selectCheckbox"]:checked');
    if (selectCheckboxArray.length === 0) {
        /* 如果使用者未勾選任何 checkbox 則回傳錯誤訊息，請使用者點選。 */
        window.alert('請點選資料');
        return;
    }

    let rowDataArray = [];

    /* 針對有勾選的[列]做處理，把該列的顏色資訊抓出來。 */
    selectCheckboxArray.each(function() {
        let customerObjKey = jQuery(this).val();
        let backgroundColor = jQuery(this).parents('tr').find('option:selected').val();

        /* 把抓出來的資料塞進 JavaScript物件裡面 */
        let unitObject = {};
        unitObject['customerObjKey'] = parseInt(customerObjKey, 10);
        unitObject['backgroundColor'] = backgroundColor;

        /* 把JavaScript物件塞進陣列 */
        rowDataArray.push(unitObject);
    });
    console.log('rowDataArray = ', rowDataArray);
    console.log('rowDataArray2 = ', JSON.stringify(rowDataArray));

    /* 接著使用AJAX技術，由JavaScript把資料輸出並發送POST請求到後端程式更新資料。 */
    let xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState === 4
                && xmlHttpRequest.status === 200
                && xmlHttpRequest.responseText === 'isOK') {
            /* 前端發送POST請求，後端回應一個response，成功後會執行此段程式。 */
            window.location.reload();
        } else if (this.readyState == 4) {
            window.alert('儲存資料失敗。');
        }
    }
    xmlHttpRequest.open('POST', pageContext + '/SaveRowColorData', true);
    xmlHttpRequest.setRequestHeader('If-Modified-Since', '0');
    xmlHttpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xmlHttpRequest.send(JSON.stringify(rowDataArray));// 發送post請求，把JSON物件打出去給後端。
});

let allCheckbox1Obj = document.getElementById('allCheckbox1');
allCheckbox1Obj.addEventListener('click', function(event) {
    /* 全選所有 checkbox */
    let allCheckboxArray = jQuery('#CustomerTable input:checkbox[name="selectCheckbox"]');
    let length = allCheckboxArray.length;
    let checkStatus = allCheckbox1Obj.checked;
    if (true === checkStatus) {
        for (let i = 0; i < length; i++) {
            allCheckboxArray.get(i).checked = true;
        }
    } else {
        for (let i = 0; i < length; i++) {
            allCheckboxArray.get(i).checked = false;
        }
    }
});

/* 設定預設 */
jQuery('#CustomerTable .theSelect').each(function() {
    let defaultColor = jQuery(this).find('option:selected').val();
    jQuery(this).css('backgroundColor', defaultColor);
    jQuery(this).parents('tr').css('backgroundColor', defaultColor);
});

/* option標籤顏色 */
jQuery('#CustomerTable .theSelect').find('option').each(function() {
    let color = jQuery(this).val();
    jQuery(this).css('backgroundColor', color);
});

/* 變更option改變背景顏色 */
jQuery('#CustomerTable .theSelect').change(function() {
    let selectedItem = jQuery(this).find('option:selected');
    jQuery(this).css('backgroundColor', selectedItem.val());
    jQuery(this).parents('tr').css('backgroundColor', selectedItem.val());
});