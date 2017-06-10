var app = angular.module('UserApp', []);
app.controller('UserController', function($scope, $http) {
	$http.get('http://agendamento.ovh.net:8080/agendamento/rest/users').then(function(response) {
		$scope.users = response.data;
		angular.forEach($scope.users, function(value, key) {
			console.log("#######################", value.username);
			angular.forEach(value, function(value1, key1) {
				console.log(key1, value1);
			});
		});
	});
});
