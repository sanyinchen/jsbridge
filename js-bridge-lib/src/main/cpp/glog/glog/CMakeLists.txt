
include_directories(./)
include_directories(../)
include_directories(./glog/src)

file(GLOB SOURCE
        glog/src/demangle.cc
        glog/src/logging.cc
        glog/src/raw_logging.cc
        glog/src/signalhandler.cc
        glog/src/symbolize.cc
        glog/src/utilities.cc
        glog/src/vlog_is_on.cc)
add_library(glog
        SHARED
        ${SOURCE}
)
