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

package stepanius.gomoku.model.config;

import stepanius.gomoku.component.ComputerMoveStrategy;
import stepanius.gomoku.component.strategy.FirstMoveToTheCenterComputerMoveStrategy;
import stepanius.gomoku.component.strategy.RandomComputerMoveStrategy;
import stepanius.gomoku.component.strategy.TryPreventUserWinComputerMoveStrategy;
import stepanius.gomoku.component.strategy.TryWinComputerMoveStrategy;

/**
 * @author stepanius
 * @link https://github.com/Stepanius
 */
public enum Level {

    LEVEL1(new ComputerMoveStrategy[]{
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()
    }),

    LEVEL2(new ComputerMoveStrategy[]{
            new TryWinComputerMoveStrategy(1),
            new TryPreventUserWinComputerMoveStrategy(1),
            new TryWinComputerMoveStrategy(2),
            new TryPreventUserWinComputerMoveStrategy(2),
            new TryWinComputerMoveStrategy(3),
            new TryPreventUserWinComputerMoveStrategy(3),
            new TryWinComputerMoveStrategy(4),
            new TryPreventUserWinComputerMoveStrategy(4),
            new FirstMoveToTheCenterComputerMoveStrategy(),
            new RandomComputerMoveStrategy()
    });

    private final ComputerMoveStrategy[] strategies;

    Level(final ComputerMoveStrategy[] strategies) {
        this.strategies = strategies;
    }

    public ComputerMoveStrategy[] getStrategies() {
        return strategies.clone();
    }
}
