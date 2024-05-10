SUMMARY = "fastcdr"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PROVIDES = "fastcdr"
PR = "r0"

inherit cmake lib_package pkgconfig

SRCREV = "aa637f9c0eae77ec41bb9c91b57b10836faba9be"
SRC_URI = "git://github.com/eProsima/Fast-CDR.git;protocol=https;branch=master \
    "
SRC_URI += "file://fastcdr_cmake_version.patch"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DINSTALL_CMAKE_DIR:PATH=${baselib}/cmake/fastcdr \
    "

