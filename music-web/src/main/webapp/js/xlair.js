(function() {

    angular.module("xlair", [])

            .controller("searchTrackController", ['$scope', '$element', '$http', function($scope, $element, $http) {

                    $scope.firstIndex = 0;
                    $scope.lastIndex = 0;
                    $scope.fetchSize = 10;
                    $scope.filter = "";
                    $scope.data = null;
                    $scope.paddingRows = [];

                    $scope.next = function() {
                        $scope.firstIndex = Math.min($scope.data.totalResultCount, $scope.firstIndex + $scope.fetchSize);
                        $scope.updateTracks();
                    };

                    $scope.last = function() {
                        $scope.firstIndex = Math.max(0, Math.floor(($scope.data.totalResultCount - 1) / $scope.fetchSize) * $scope.fetchSize);
                        $scope.updateTracks();
                    };

                    $scope.previous = function() {
                        $scope.firstIndex = Math.max(0, $scope.firstIndex - $scope.fetchSize);
                        $scope.updateTracks();
                    };

                    $scope.first = function() {
                        $scope.firstIndex = 0;
                        $scope.updateTracks();
                    };

                    $scope.updateTracks = function() {
                        var params = {
                            'firstIndex': $scope.firstIndex,
                            'fetchSize': $scope.fetchSize
                        };
                        if($scope.filter !== ""){
                            params['filter'] = $scope.filter;
                        }
                        $http({
                            url: "/xlair/service/track",
                            method: 'GET',
                            params: params
                        }).success(function(data) {
                            $scope.data = data;
                            $scope.paddingRows = new Array($scope.fetchSize - data.results.length);
                        }).error(function(data, status, headers, config) {
                            alert("error: " + status);
                        });
                    };
                    $scope.updateTracks();
                }]);

})();