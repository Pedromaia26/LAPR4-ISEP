function loadWarehouse() {
	var request = new XMLHttpRequest();
    var vWarehouse=document.getElementById("warehouse");

    request.onload = function() {
        vWarehouse.innerHTML = this.responseText;
        vWarehouse.style.color="black";

        setTimeout(movement, 1000);
    };

    request.ontimeout = function() {
        vWarehouse.innerHTML = "Server timeout, still trying ...";
        vWarehouse.style.color="red";
        setTimeout(loadWarehouse, 15000);
    };

    request.onerror = function() {
        vWarehouse.innerHTML = "No server reply, still trying ...";
        vWarehouse.style.color="red";
        setTimeout(loadWarehouse, 15000);
    };
    request.open("GET", "/warehouse", true);
    request.timeout = 15000;
    request.send();

}

function movement(){
    var request = new XMLHttpRequest();
    var vWarehouse=document.getElementById("warehouse");

    request.onload = function() {
        vWarehouse.innerHTML = this.responseText;
        vWarehouse.style.color="black";

        setTimeout(movement, 1000);
    };

    request.open("PUT", "/movement", true);
    request.send();
}

	
