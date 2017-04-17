Application.$controller("PersonHistoryPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };





    $scope.LSUCPersonAudDataonSuccess = function(variable, data) {
        for (var i = 0; i < data.length; i++) {
            debugger;
            if (data.length === i)
                return false;
            _.mergeWith(data[i], data[i + 1],
                function(objectValue, sourceValue, key, object, source) {
                    if (key == "rev" || key == "revtstmp") {
                        return;
                    }
                    if (!(_.isEqual(objectValue, sourceValue)) && (Object(objectValue) !== objectValue)) {
                        if (source.revtype == 1) {
                            $scope.Variables.CommentsObj.dataSet.icon = "wi wi-edit";
                            source.revtype = "UPDATED"
                        } else {
                            source.revtype = "CREATED"
                        }
                        $scope.Variables.CommentsObj.dataSet.action = source.revtype,
                            $scope.Variables.CommentsObj.dataSet.heading = "Edited  " + key,
                            $scope.Variables.CommentsObj.dataSet.comment = key + " changed to " + sourceValue + " Old Value is  " + objectValue,
                            $scope.Variables.CommentsObj.dataSet.time = source.revinfo.revtstmp,
                            $scope.Variables.CommentsObj.dataSet.days = source.revinfo.revtstmp
                        $scope.Variables.CommentsArr.dataSet.push($scope.Variables.CommentsObj.dataSet);
                        // console.log($scope.Variables.CommentsArr.dataSet);
                    }
                });
        }
    };





    $scope.livelist2groupby = function(rowData) {
        return rowData.type + '<br/><p class="text-muted">' + rowData.name + ' (' + rowData.id + ')</p>';
        /*
         * this function is iterated over each data object in the livelist dataSet collection the data will be grouped by what is returned from this function E.g. to group a collection of CGPA details under rounded figure CGPA return following return Math.floor(dataObject.cgpa)
         */
    };

}]);


Application.$controller("grid1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("liveform1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);