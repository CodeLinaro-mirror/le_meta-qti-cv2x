SUMMARY = "fastdds"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS += "fastcdr libtinyxml2 asio foonathan-memory-vendor"

PROVIDES = "fastdds"
PR = "r0"

inherit cmake lib_package pkgconfig

SRCREV = "00953731a1e2724d748e4293f4aa295537d149b7"
SRC_URI = "git://github.com/eProsima/Fast-DDS.git;protocol=https;branch=master \
    "
SRC_URI += "file://fastdds_cmake_version.patch"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DCOMPILE_TOOLS=ON \
    "
FILES:${PN} += "${datadir}/* \
               ${datadir}/fastrtps/* \
               ${datadir}/fastrtps/cmake/* \
               ${prefix}/tools/fastdds/* \
               ${bindir}/fast-discovery-server-1.0.1 \
    "
SYSROOT_DIRS += " ${bindir} "
