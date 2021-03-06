#!/usr/bin/env sh
#
# Copyright 2019. 2022. https://github.com/Stepanius
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
########################################################################################################################
# The sh script to start the gomoku game for Unix systems                                                         #
#                                                                                                                      #
# @author devonline                                                                                                    #
# @email  devonline.academy@gmail.com                                                                                  #
########################################################################################################################
# ----------------------------------------------------------------------------------------------------------------------
# Fix current dir issue for MacOS. Read more: http://hints.macworld.com/article.php?story=20041217111834902
cd "$(dirname "$0")" || exit
# ----------------------------------------------------------------------------------------------------------------------
# delay=300 - this config parameter uses millis unit, i.e. `delay=300` equal to `delay=300 millis`
./start.sh computer computer delay=300
