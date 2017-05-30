angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://agendamento.ovh.net:8080/agendamento/rest/users/1').
        then(function(response) {
            $scope.user = response.data;
        });
});