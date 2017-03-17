'use strict';

angular.module('app', []).
	controller('control', function($scope, $http) {
	var ctrl=this;	

	$http.get('http://localhost:8080/proveedor/showproveedore').
		then(function(response) {
			ctrl.listausuarios = response.data;
		});

});