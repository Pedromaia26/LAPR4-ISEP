function loadWarehouse() {
	var request = new XMLHttpRequest();
    var vWarehouse=document.getElementById("warehouse");

    request.onload = function() {
        vWarehouse.innerHTML = this.responseText;
        vWarehouse.style.color="black";

        setTimeout(loadWarehouse, 15000);
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
    request.timeout = 5000;
    request.send();
}

function voteFor(option) {
	var request = new XMLHttpRequest();
  	request.open("PUT", "/votes/" + option , true);
  	request.send();
    var vWarehouse=document.getElementById("warehouse");
    vBoard.innerHTML = vBoard.innerHTML + "<p>Casting your vote ... Please wait.";

}
	

