


include_directories(./*)
include_directories(./jsi)
include_directories(./include)

file(GLOB_RECURSE SOURCE
        ./*.cpp
        ./JSExecutor.cpp
        ./JSLogging.cpp
        ./OnLoad.cpp
)

add_library(jscexecutor
        SHARED
        ${SOURCE}
)


target_link_libraries(jscexecutor
        fbjni
        folly_json
        js-bridge
        jsc
)
