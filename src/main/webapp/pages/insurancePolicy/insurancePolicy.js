Application.$controller("insurancePolicyPageController", ["$scope", function($scope) {
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

    $scope.policyFormSuccess = function($event, $operation, $data, item, currentItemWidgets) {
        $timeout(function() {
            $scope.Widgets.policyForm.isUpdateMode = false;
        });
    };

}]);

Application.$controller("policyFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.policyUpBtnClick = function($event, $isolateScope, item, currentItemWidgets) {
            $scope.isUpdateMode = true;
        };

    }
]);