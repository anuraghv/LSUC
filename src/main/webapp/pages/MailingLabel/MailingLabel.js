Application.$controller("MailingLabelPageController", ["$scope", function($scope) {
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




    $scope.addBtnClick = function($event, $isolateScope) {
        /*On click of add, open the form in insert mode*/
        $scope.Widgets.mailingLabelLiveForm.new();
    };


    $scope.editBtnClick = function($event, $isolateScope) {
        /*On click of add, open the form in edit mode*/
        $scope.Widgets.mailingLabelLiveForm.edit();
    };

}]);


Application.$controller("mailingLabelGridController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("mailingLabelLiveFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);