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

package stepanius.gomoku.component.strategy;


import stepanius.gomoku.model.game.Sign;

/**
 * @author stepanius
 * @link https://github.com/Stepanius
 */
public class TryPreventUserWinComputerMoveStrategy extends AbstractComputerMoveStrategy {

    public TryPreventUserWinComputerMoveStrategy(final int expectedCountEmptyCells) {
        super(expectedCountEmptyCells);
    }

    @Override
    protected Sign getFindSign(final Sign moveSign) {
        return moveSign.oppositeSign();
    }
}

