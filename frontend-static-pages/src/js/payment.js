window.onload = function(){
    //获取显示隐藏按钮DOM对象
    let showBtn = document.getElementById('showBtn');
    //获取订单明细DOM对象
    let detailetBox = document.getElementById('detailetBox');
    //默认隐藏
    detailetBox.style.display = 'none'

    showBtn.onclick = function(){
        //判断订单明细DOM对象是否隐藏
        if(detailetBox.style.display == 'none'){
            detailetBox.style.display = 'block';
        }else{
            detailetBox.style.display = 'none';
        }
    }
}