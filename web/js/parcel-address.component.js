// Register `phoneList` component, along with its associated controller and template
angular.
  module('parcelConfig').
  component('parcelAddress', {
	  transclude: true,
	  template:
    	'<div class="w3-panel w3-card-2">'+
    		'<div class="w3-container w3-teal">'+
    			'<h2>Lieferadresse</h2>'+
    		'</div>' +
    		'<form class="w3-container">'+
    	  '<div class="w3-cell">'+
    	  '<h3>Empfänger</h3>'+
    	  
    	  '<div class="w3-cell">'+
   		  '<label>Vor- und Nachname</label>'+
   		  '<input class="w3-input" id="cfg-size-length" type="text" ng-model="$ctrl.parcel.recipient.name">'+
   		  '</div>'+
   		  
   		 '<div class="w3-cell">'+
   		  '<label>Firma</label>'+
   		  '<input class="w3-input" id="cfg-size-height" type="text" ng-model="$ctrl.parcel.recipient.firm">'+
   		  '</div>'+
   		 
   		  '<div class="w3-row">'+
   		  	'<div class="w3-cell">'+
   		  	'<label>Straße</label>'+
   		  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.recipient.street">'+
   		  	'</div>'+
   		  	'<div class="w3-cell">'+
   		  	'<label>Nr.</label>'+
		  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.recipient.nr">'+
		  	'</div>'+
   		  '</div>'+
	   	  '<div class="w3-row">'+
			 '<div class="w3-cell">'+
			  	'<label>PLZ</label>'+
			  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.recipient.plz">'+
			 '</div>'+
			  	'<div class="w3-cell">'+
			  	'<label>Ort</label>'+
			  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.recipient.city">'+
			 '</div>'+
		  '</div>'+
		  '</div>'+
		  
		  '<div class="w3-cell">'+
		 ' &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;'+
		  '</div>'+
		  
		  
		  '<div class="w3-cell">'+
    	  '<h3>Absender</h3>'+
    	  
    	  '<div class="w3-cell">'+
   		  '<label>Vor- und Nachname</label>'+
   		  '<input class="w3-input" id="cfg-size-length" type="text" ng-model="$ctrl.parcel.sent.name">'+
   		  '</div>'+
   		  
   		 '<div class="w3-cell">'+
   		  '<label>Firma</label>'+
   		  '<input class="w3-input" id="cfg-size-height" type="text" ng-model="$ctrl.parcel.sent.firm">'+
   		  '</div>'+
   		 
   		  '<div class="w3-row">'+
   		  	'<div class="w3-cell">'+
   		  	'<label>Straße</label>'+
   		  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.sent.street">'+
   		  	'</div>'+
   		  	'<div class="w3-cell">'+
   		  	'<label>Nr.</label>'+
		  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.sent.nr">'+
		  	'</div>'+
   		  '</div>'+
	   	  '<div class="w3-row">'+
			 '<div class="w3-cell">'+
			  	'<label>PLZ</label>'+
			  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.sent.plz">'+
			 '</div>'+
			  	'<div class="w3-cell">'+
			  	'<label>Ort</label>'+
			  	'<input class="w3-input" id="cfg-size-depth" type="text" ng-model="$ctrl.parcel.sent.city">'+
			 '</div>'+
		  '</div>'+
		  '</div>'+
   		  '</form>'+
   		  '</div>',
    	
    controller: function ParcelAddressController($rootScope) {
    	this.recipient = {
       		 name: '',
       		 street: '',
       		 nr: '',
       		 plz: '',
       		 city: ''
        } ;
    this.sent = {
    		 name: '',
    		 street: '',
    		 nr: '',
    		 plz: '',
    		 city: ''
     };
      $rootScope.sent = this.sent;
    	$rootScope.recipient = this.recipient;
    }
  });
  
 
  