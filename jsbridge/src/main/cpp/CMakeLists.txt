# Copyright (c) Facebook, Inc. and its affiliates.
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

cmake_minimum_required(VERSION 3.6.0)
project(fbjni CXX)

include(GNUInstallDirs)

include_directories(.)
set(FBJNI_COMPILE_OPTIONS
        -Wall
        -std=c++14
        -pthread
        -fno-omit-frame-pointer
        -fexceptions
        -frtti
        -ffunction-sections
        -O3
        -DNDEBUG
        )

file(GLOB fbjni_SOURCES
        fbjni/*.cpp
        fbjni/detail/*.cpp
        lyra/*.cpp
        )

add_library(fbjni SHARED ${fbjni_SOURCES})

target_compile_options(fbjni PRIVATE ${FBJNI_COMPILE_OPTIONS})
target_compile_options(fbjni PRIVATE -DBUILDING_FBJNI)

target_link_libraries(fbjni android log)

