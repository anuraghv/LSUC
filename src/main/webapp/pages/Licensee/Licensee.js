Application.$controller("LicenseePageController", ["$scope", "$timeout", function($scope, $timeout) {
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

    /*This method is called before save of add licensee form*/
    $scope.addLicenseeBeforeservicecall = function($event, $operation, $data) {
        /*if effective date is undefined, set default value*/
        if ($scope.Widgets.licenseeclasspracticegroupsForm.dataoutput.effectiveToDate === undefined) {
            $scope.Widgets.licenseeclasspracticegroupsForm.dataoutput.effectiveToDate = "2999-12-31";
        }
    };

    /*On licensee form success, Add the licensee status data to the approval data*/
    $scope.addLicenseeSuccess = function($event, $operation, $data) {
        var dataOutput = $scope.Widgets.licenseeclasspracticegroupsForm.dataoutput;
        /* If effective date is not selected, set the default value*/
        if (dataOutput.effectiveToDate == undefined) {
            dataOutput.effectiveToDate = '9999-12-31';
        }
        /* Set the inputs for LSUC_ApprovalData variable*/
        $scope.Variables.LSUC_ApprovalData.setInput({
            "licenseeFk": $data.pk,
            "newIsPrimary": dataOutput.isPrimary,
            "newEffectiveFromDate": dataOutput.effectiveFromDate,
            "newEffectiveToDate": dataOutput.effectiveToDate,
            "newClassPracticeGroupFk": dataOutput.classpraticegroup.pk,
            "status": "Created"
        });
        /* Insert data in LSUC_ApprovalData*/
        $scope.Variables.LSUC_ApprovalData.insertRecord();
    };

    /*This method is called before the variable call is made*/
    $scope.getAssociatedPracticeGroupsonBeforeUpdate = function(variable, inputData) {
        /*If class is not selected, do not send the call for practice groups*/
        if ($scope.Widgets.licenseeclasspracticegroupsForm.formWidgets.dummyClass.datavalue === undefined) {
            return false;
        }

    };

    /*on click of add button, open add Licensee form*/
    $scope.addLicenseBtnClick = function($event, $isolateScope) {
        $scope.Widgets.addLicensee.new();
        /*Focus the first field in the form*/
        $timeout(function() {
            $scope.Widgets.licenseeNumber.focus()
        });

    };

}]);

Application.$controller("addLicenseeController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("licenseeclasspracticegroupsFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);