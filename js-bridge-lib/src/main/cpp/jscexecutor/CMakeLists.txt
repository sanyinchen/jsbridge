


include_directories(./*)

file(GLOB SOURCE ./*.cpp)
add_library(jscexecutor
        SHARED
        ${SOURCE}
)


target_link_libraries(jscexecutor
        jsi
        jsireact
        folly_json
        fb
        js-bridge
)