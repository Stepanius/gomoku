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
package stepanius.gomoku;


import stepanius.gomoku.component.CellVerifier;
import stepanius.gomoku.component.ComputerMove;
import stepanius.gomoku.component.Game;
import stepanius.gomoku.component.UserMove;
import stepanius.gomoku.component.WinnerVerifier;
import stepanius.gomoku.component.config.CommandLineArgumentParser;
import stepanius.gomoku.component.swing.GameWindow;
import stepanius.gomoku.model.config.Level;
import stepanius.gomoku.model.config.PlayerType;
import stepanius.gomoku.model.game.Player;

import static stepanius.gomoku.model.config.PlayerType.USER;
import static stepanius.gomoku.model.game.Sign.O;
import static stepanius.gomoku.model.game.Sign.X;

/**
 * @author stepanius
 * @link https://github.com/Stepanius
 */
public class GameFactory {

    private final PlayerType player1Type;

    private final PlayerType player2Type;

    private final Level level;

    private final int size;

    private final long delayInMillis;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.CommandLineArguments commandLineArguments =
                new CommandLineArgumentParser(args).parse();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        level = commandLineArguments.getLevel();
        size = commandLineArguments.getSize().intValue();
        delayInMillis = commandLineArguments.getDelayInMillis();
    }

    public Game create() {
        final GameWindow gameWindow = new GameWindow(size);
        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(gameWindow, gameWindow));
        } else {
            player1 = new Player(X, new ComputerMove(level.getStrategies(), delayInMillis));
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(gameWindow, gameWindow));
        } else {
            player2 = new Player(O, new ComputerMove(level.getStrategies(), delayInMillis));
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                size,
                gameWindow,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeFirstMove
        );
    }
}
