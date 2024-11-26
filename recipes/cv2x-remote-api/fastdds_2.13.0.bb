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

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/cv2x_extra \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DCOMPILE_TOOLS=OFF \
    -DEPROSIMA_BUILD=OFF \
    -DCHECK_DOCUMENTATION=OFF \
    -DSQLITE3_SUPPORT=OFF \
    -DENABLE_OLD_LOG_MACROS=OFF \
    -DFASTDDS_STATISTICS=OFF \
    -DCOMPILE_EXAMPLES=OFF \
    -DINSTALL_EXAMPLES=OFF \
    -DINSTALL_TOOLS=OFF \
    -DINTERNAL_DEBUG=OFF \
    -DIS_THIRDPARTY_BOOST_OK=OFF \
    "
FILES:${PN} += "/cv2x_extra/${datadir}/* \
               /cv2x_extra/${datadir}/fastrtps/* \
               /cv2x_extra/share/* \
               /cv2x_extra/share/fastrtps/* \
               /cv2x_extra/share/fastrtps/cmake/* \
               /cv2x_extra/bin/fast-discovery-server-1.0.1 \
               /cv2x_extra/lib/* \
    "
FILES:${PN}-dev ="/cv2x_extra/include"
do_install:append() {
    rm -rf ${D}/usr/lib/foonathan_memory
}

SYSROOT_DIRS += " ${bindir} "
SYSROOT_DIRS:append = "/cv2x_extra"
INSANE_SKIP:${PN} += "dev-so"

