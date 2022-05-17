    const gifOut = document.querySelector('.gif-out');
    document.getElementById("comparedButton").addEventListener("click" , getGifByCurrency);

    function getGifByCurrency() {
    var sel = document.getElementById("currencySelect"); 
    var val = sel.options[sel.selectedIndex].value;
    let url = new URL("http://localhost:9000/giphy-app/api/random-gif");
    url.search  = new URLSearchParams({currency: val});
    fetch(url)
        .then(response => response.json())
        .then(content => {
        console.log(content.data);
        console.log("META", content.meta);
        let img = new Image();
        img.src = content.data.images.original.url;
        gifOut.append(img)
        })
    }