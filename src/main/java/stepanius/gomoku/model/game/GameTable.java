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
package stepanius.gomoku.model.game;

import java.util.Arrays;

import static stepanius.gomoku.model.game.Sign.EMPTY;


/**
 * @author stepanius
 * @link https://github.com/Stepanius
 */
public class GameTable {

    private final Sign[][] table;

    public GameTable(final int size) {
        table = new Sign[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = EMPTY;
            }
        }
    }

    public boolean isEmpty(final Cell cell) {
        return table[cell.getRow()][cell.getCol()] == EMPTY;
    }

    public Sign getSign(final Cell cell) {
        return table[cell.getRow()][cell.getCol()];
    }

    public void setSign(final Cell cell, final Sign sign) {
        table[cell.getRow()][cell.getCol()] = sign;
    }

    public boolean isValid(final Cell cell) {
        return cell.getRow() >= 0 && cell.getRow() < getSize() &&
                cell.getCol() >= 0 && cell.getCol() < getSize();
    }

    public int getSize() {
        return table.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameTable{");
        sb.append("table=");
        for (int i = 0; i < table.length; i++) {
            sb.append(Arrays.toString(table[i]));
            if (i < table.length - 1) {
                sb.append(';');
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
