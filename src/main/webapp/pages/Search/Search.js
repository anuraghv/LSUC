Application.$controller("SearchPageController", ["$scope", function($scope) {
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
        // var valueObj = {
        //         'value': $scope.pageParams.q
        //     },
        //     fields = ['licenseeNumber', 'pk', 'archiveBoxNumber'],
        //     filterFields = {};
        // _.forEach(fields, function(field) {
        //     filterFields[field] = valueObj
        // });
        // debugger
        // $scope.Variables.LSUCLicenseeData.listRecords({
        //     'logicalOp': 'OR',
        //     'filterFields': filterFields
        // });
    };


    $scope.LSUCLicenseeDataonBeforeUpdate = function(variable, inputData) {
        variable.options = {
            'logicalOp': 'OR'
        };
    };

    $scope.LSUCPersonDataonBeforeUpdate = function(variable, inputData) {
        variable.listRecords({
            'logicalOp': 'OR'
        });
    };


    $scope.LSUCBusinessDataonBeforeUpdate = function(variable, inputData) {
        variable.listRecords({
            'logicalOp': 'OR'
        });
    };

}]);