/*
 * Copyright (c) 2022. https://github.com/Stepanius?tab=repositories
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package stepanius.gomoku.component;


import stepanius.gomoku.model.game.Cell;
import stepanius.gomoku.model.game.GameTable;
import stepanius.gomoku.model.game.Sign;

/**
 * @author stepanius
 * @link https://github.com/Stepanius
 */
public class UserMove implements Move {

    private final UserInputReader userInputReader;

    private final DataPrinter dataPrinter;

    public UserMove(final UserInputReader userInputReader,
                    final DataPrinter dataPrinter) {
        this.userInputReader = userInputReader;
        this.dataPrinter = dataPrinter;
    }

    @Override
    public void make(final GameTable gameTable, final Sign sign) {
        while (true) {
            final Cell cell = userInputReader.getUserInput();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printErrorMessage("Can't make a move, because the cell is not free! Try again");
            }
        }
    }
}
