Application.$controller("LicensePageController", ["$scope", "$timeout", function($scope, $timeout) {
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


    /* This method is executed on before sending the save call of add Language*/
    $scope.addLanguageFormBeforeservicecall = function($event, $operation, $data) {
        /* Create licenseepersonlanguagepurposes along with language*/
        $data['licenseepersonlanguagepurposes'] = [{
            languagePurposeFk: $data.languagepurpose,
            licenseeFk: $scope.Variables.LicenseeData.firstRecord.pk
        }]
    };

    /* This method is executed on before sending the save call of license status*/
    $scope.licenseStatusFormBeforeservicecall1 = function($event, $operation, $data, item, currentItemWidgets) {
        /* If effective date is not selected, set the default value*/
        if ($data.effectiveToDate == undefined) {
            $data.effectiveToDate = '9999-12-31';
        }
        /* Set the inputs for LSUC_ApprovalData variable*/
        $scope.Variables.LSUC_ApprovalData.setInput({
            "licenseeFk": $data.licenseeFk,
            "newIsPrimary": $data.isPrimary,
            "newEffectiveFromDate": $data.effectiveFromDate,
            "newEffectiveToDate": $data.effectiveToDate,
            "newClassPracticeGroupFk": $data.classPracticeGroupFk,
            "status": "Updated",
            "licenseeclasspracticegroupPk": $data.pk
        });
        /* Insert data in LSUC_ApprovalData*/
        $scope.Variables.LSUC_ApprovalData.insertRecord({}, function() {
            /* On success, close the live form*/
            currentItemWidgets.licenseStatusForm.cancel();
        });
        return false;
    };


    /* This method is executed on before sending the call for licenseStatusData variable*/
    $scope.licenseStatusDataonBeforeUpdate = function(variable, inputData) {
        /*If licenseeFk is not present, dont make the call*/
        if (inputData && !inputData.licenseeFk) {
            return false;
        }
    };


    $scope.addLicenseeStatusBtnClick = function($event, $isolateScope) {
        /* Open the addLicenseeStatusForm form in insert mode */
        $scope.Widgets.addLicenseeStatusForm.new()
            /* Focus the first field of the form */
        $timeout(function() {
            $scope.Widgets.dummyClass.focus();
        });
    };

    /* This method is executed on before sending the call for licenseStatusData variable*/
    $scope.getAssociatedPracticeGroupsonBeforeUpdate = function(variable, inputData) {
        /* If the class field value is not selected, do not make the call for practice groups */
        if ($scope.Widgets.addLicenseeStatusForm.formWidgets.dummyClass.datavalue == undefined) {
            return false;
        }

    };

    /* This method is executed on before sending the save call for addInsuranceForm*/
    $scope.addInsuranceFormBeforeservicecall = function($event, $operation, $data) {
        /*Save the licenseeinsurancepolicies data collected from inside form*/
        $data.licenseeinsurancepolicies = [$scope.Widgets.policyForm.dataoutput];
    };


    $scope.addInsBtnClick = function($event, $isolateScope) {
        /* Open the addInsuranceForm form in insert mode */
        $scope.Widgets.addInsuranceForm.new();
        /* Focus the first field of the form */
        $timeout(function() {
            $scope.Widgets.insurancecoveragetype.focus();
        });
    };

}]);


Application.$controller("licenseStatusFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.licenseStUpBtnClick = function($event, $isolateScope) {
            /*Edit the licenseStatusForm on click of edit button*/
            $scope.edit();
        };

    }
]);

Application.$controller("licenseDetailsFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.licenseDetUpBtnClick = function($event, $isolateScope) {
            /*Edit the licenseDetailsForm on click of edit button*/
            $scope.edit();
        };

    }
]);

Application.$controller("languagedatatableController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.addNewRowAction = function($event) {
            /*Open the licenseDetailsForm on click of add button*/
            $scope.Widgets.addLanguageForm.new();
        };

    }
]);


Application.$controller("licenseeinsurancepolicyDialogController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("addInsuranceFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("policyFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);



Application.$controller("addLanguageFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("addLicenseeStatusFormController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);