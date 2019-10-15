$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"/dateOper/getUser",
        datatype:"json",
        success:function (data) {
            if(data.code==0){
                console.log(dateOper(data.payload.createTime,2));
            }
        }
    })
    function dateOper(dateDomain,dateFormId) {
        var dateParts = new Array();
        var ymd = new Array();
        var hms = new Array();
        dateParts = dateDomain.split('T');
        ymd = dateParts[0].split('-');
        hms = dateParts[1].split('.')[0].split(':');
        switch(dateFormId) {
            case 1:
                return ymd[0]+"年"+ymd[1]+"月"+ymd[2]+"日 "+hms[0]+"时"+hms[1]+"分"+hms[2]+"秒";
            case 2:
                return ymd[2]+"/"+ymd[1]+"/"+ymd[0];
            case 3:
                return ymd[0]+"年"+ymd[1]+"月"+ymd[2]+"日";
            case 4:
                return ymd[2]+"/"+ymd[1]+"/"+ymd[0]+" "+hms[0]+":"+hms[1]+":"+hms[2];
            case 5:
                return hms[0]+":"+hms[1]+":"+hms[2];
            default:
                return dateParts[0]+" "+dateParts[1].split('.')[0];
        }
    }
})