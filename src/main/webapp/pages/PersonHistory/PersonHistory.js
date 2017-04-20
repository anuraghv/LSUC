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
        $scope.PersonAudData = data.length;
        $scope.Variables.personHistoryData.dataSet = [];
        for (var i = 0; i < data.length - 1; i++) {
            var historyData = {
                "type": "edit",
                "entity": "status",
                "newPropertyValues": [],
                "oldPropertyValues": [],
                "changedby": "Gerald",
                "timestamp": ""
            };
            var original = data[i],
                latest = data[i + 1];
            _.reduce(original, function(result, val, key) {
                var newobj = {
                    types: "",
                    value: ""
                }
                var oldObj = {
                    types: "",
                    value: ""
                }
                if (!_.isEqual(latest[key], val) && !_.includes(["rev", "revinfo"], key)) {
                    historyData.type = "Person Details Changed";
                    newobj.types = key || "NULL";
                    newobj.value = latest[key] || "NULL";
                    historyData.newPropertyValues.push(newobj);
                    oldObj.types = key || "NULL";
                    oldObj.value = val || "NULL";
                    historyData.oldPropertyValues.push(oldObj);
                    historyData.timestamp = latest.revinfo.revtstmp;
                }

            });
            $scope.Variables.personHistoryData.dataSet.push(historyData);
        }


    };





    // $scope.livelist2groupby = function(rowData) {
    //     return rowData.type + '<br/><p class="text-muted">' + rowData.name + ' (' + rowData.id + ')</p>';
    //     /*
    //      * this function is iterated over each data object in the livelist dataSet collection the data will be grouped by what is returned from this function E.g. to group a collection of CGPA details under rounded figure CGPA return following return Math.floor(dataObject.cgpa)
    //      */
    // };

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