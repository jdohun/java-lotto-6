package lotto.generator;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.WinningNumber;
import lotto.domain.validator.Validator;
import lotto.view.InputView;

public class BonusNumberGenerator {

    public BonusNumber run(WinningNumber winningNumber) {
        int inputBonusNumber = drawBonusNumber();

        try {
            BonusNumber bonusNumber = winningNumber.createBonusNumber(inputBonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.run(winningNumber);
        }
    }

    private int drawBonusNumber() {
        String inputBonusValue = InputView.inputBonusNumber();

        try {
            Validator.validateExistValue(inputBonusValue);
            int convertedBonusNum = Validator.validateNumericInput(inputBonusValue.trim());
            int bonusNumberInRange = Validator.validateNumberInRange(convertedBonusNum);

            return bonusNumberInRange;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.drawBonusNumber();
        }
    }
}
