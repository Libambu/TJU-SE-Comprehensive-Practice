window.onload = function() {
    document.onscroll = function() {
        // Get the scroll position
        let s1 = document.documentElement.scrollTop;
        let s2 = document.body.scrollTop;
        let s = s1==0? s2 : s1;

        let width = document.documentElement.clientWidth;
        let search = document.getElementById("fixedBox");
        if(s>width*0.12){
            search.style.position = "fixed";
            search.style.top = "0";
            search.style.left = "0";
        }else{
            search.style.position = "static";
        }
    }
}