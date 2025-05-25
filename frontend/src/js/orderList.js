window.onload=function() {
    let showBtnArr=document.getElementsByClassName('fa-caret-down');
    let detailetBoxArr=document.getElementsByClassName('order-detailet');
    for (let i=0;i<detailetBoxArr.length;i++) {
        detailetBoxArr[i].style.display='none';
    }
    for (let i=0;i<showBtnArr.length;i++) {
        showBtnArr[i].onclick=function() {
            if (detailetBoxArr[i].style.display == 'none') {
                detailetBoxArr[i].style.display = 'block';
            }
            else {
                detailetBoxArr[i].style.display = 'none';
            }
        }
    }
}