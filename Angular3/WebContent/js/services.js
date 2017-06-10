/**
 * Created by Sandeep on 01/06/14.
 */

// return $resource('http://agendamento.ovh.net:8080/agendamento/rest/users/:id',{id:'@_id'},{

angular.module('movieApp.services',[]).factory('Movie',function($resource){
    return $resource('http://localhost:8080/agendamento/rest/users/:id',{id:'@_id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});