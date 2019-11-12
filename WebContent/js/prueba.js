$(document).ready(function() {
	initGeozoneMapNew2();
});

var map;
var mapRead;
var mapEdit;
var marker;
var colorGeozone = '#1ab394'
var cpCircle;
var pointMarker = [];// store marker in array
var cpPolygon;
var mapNew;
var markersArray = [];
var colorGeozoneAdd = '#1ab394'
var isNew = 1;
var markerCenter;
var myLatlng;
function initGeozoneMapNew2() {

	console.log('Nueva geozona en mapa');
	isNew = 1;
//	myframe = '#frmMapaNew';
	
	myLatlng = new google.maps.LatLng({
		lat : -34.6131516,
		lng : -58.3772316
	});
	mapNew = new google.maps.Map($('#map')[0], {
		center : myLatlng,
		zoom : 12,
		disableDefaultUI : true
	});
	
	cpCircle = null;
	cpPolygon = null;
//

	mapNew.addListener('click', function(e) {
//		$("#txtCircle").val(tipo);
	//	$("#txtCircle").val(1);
		placeMarkerAndPanTo(e.latLng, mapNew);   
	});

}


function placeMarkerAndPanTo(latLng, map) {

        console.log('prueba');
		map.panTo(latLng);
		smoothZoom(map, 17, map.getZoom());
		var tipo = $("#circle").val();
		console.log('tipo:'+tipo);

		if (tipo == 0) {
			cpCircle = new google.maps.Circle({
				strokeColor : '#FF0000',
				strokeOpacity : 0.8,
				strokeWeight : 2,
				fillColor : '#FF0000',
				fillOpacity : 0.35,
				map : map,
				center : latLng,
				radius : 100,
				draggable: true,
				editable : true
			});
			
			handleCircle();
			cpCircle.addListener('center_changed', handleCircle);
			cpCircle.addListener('radius_changed', handleCircle);
			$("#circle").val(2);
		} 
}
function handleCircle() {
	var lt = cpCircle.getCenter().lat();
	var lg = cpCircle.getCenter().lng();
	var rd = cpCircle.getRadius();
	console.log('lat:'+lt);
	console.log('long:'+lg);
	console.log('radio:'+rd);
	$("#txtLatitud").val(lt);
	$("#txtLongitud").val(lg);
	$("#txtRadio").val(rd);

//	$(myframe + '\\:markerLat').val(cpCircle.getCenter().lat());
//	$(myframe + '\\:markerLng').val(cpCircle.getCenter().lng());
//
//	$(myframe + '\\:iptRadius').val(cpCircle.getRadius().toFixed(0));

}

function smoothZoom(map, max, cnt) {
	if (cnt >= max) {
		return;
	} else {
		z = google.maps.event.addListener(map, 'zoom_changed', function(event) {
			google.maps.event.removeListener(z);
			smoothZoom(map, max, cnt + 1);
		});
		setTimeout(function() {
			map.setZoom(cnt)
		}, 80); // 80ms is what I found to work well on my system -- it might
		// not work well on all systems
	}
}






