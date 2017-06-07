angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/agendamento/rest/hello').
        then(function(response) {
            $scope.hello = response.data;
        });
});

var myapp = angular.module('meuModulo', []);
myapp.controller('myController', function($scope, $http) {
	console.log($scope);
    console.log($http);
});