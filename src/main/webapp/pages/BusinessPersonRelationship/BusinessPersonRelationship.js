Application.$controller("BusinessPersonRelationshipPageController", ["$scope", "$timeout", function($scope, $timeout) {
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



    $scope.LSUCBusinesspersonrelationshipData1onBeforeUpdate = function(variable, inputData) {
        inputData['businessperson.businessFk'] = {
            'value': $scope.pageParams.businessId
        };
    };


    $scope.deleteBusinessPersonRelBtnClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.LSUCBusinesspersonrelationshipData1.setInput('pk', item.pk);
        $scope.Variables.LSUCBusinesspersonrelationshipData1.deleteRecord();
    };


    $scope.addBusinessPersonRelonBeforeUpdate = function(variable, inputData) {
        inputData['businessperson.businessFk'] = {
            'value': $scope.pageParams.businessId
        };
    };


    $scope.addBusinessPersonFormBeforeservicecall = function($event, $operation, $data) {
        $data['businesspersonrelationships'] = [$scope.Widgets.businessPersonRelForm.dataoutput];
    };


    $scope.addBusinessPersonRelBtnClick = function($event, $isolateScope) {
        $timeout(function() {
            $scope.Widgets.person.focus();
        });
    };

}]);

Application.$controller("businessPersonRelTableController", ["$scope",
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

Application.$controller("businessPersonRelFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("addBusinessPersonFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);