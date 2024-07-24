

include_directories(./folly)


file(GLOB SOURCE "json.cpp"
        "Unicode.cpp"
        "Conv.cpp"
        "Demangle.cpp"
        "memory/detail/MallocImpl.cpp"
        "String.cpp"
        "dynamic.cpp"
        "Format.cpp"
        "json_pointer.cpp"
        "lang/ColdClass.cpp"
        "detail/Demangle.cpp"
        "hash/SpookyHashV2.cpp"
        "container/detail/F14Table.cpp"
        "ScopeGuard.cpp"
        "lang/Assume.h")


add_library(folly_json
        SHARED
        ${SOURCE}
)

target_link_libraries(folly_json
        glog
        double-conversion
        boost)