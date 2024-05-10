SUMMARY = "foonathan_memory_vendor"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

PROVIDES = "foonathan_memory_vendor"
PR = "r0"

inherit cmake lib_package pkgconfig

SRCREV = "48e5e2c9a1e4948c80e11d5aec78e23dc27b6714"
SRC_URI = "git://github.com/eProsima/foonathan_memory_vendor.git;protocol=https;branch=master \
    "
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_MEMORY_TOOLS=OFF \
    "

FILES_${PN} += "${datadir}/foonathan_memory/* \
               ${datadir}/foonathan_memory_vendor/* \
               ${datadir}/foonathan_memory_vendor/cmake/* \
               ${libdir}/foonathan_memory/cmake/* \
               ${libdir}/ibfoonathan_memory.so \
    "
do_install_append() {
    ln -sf libfoonathan_memory-0.7.3.so ${D}${libdir}/ibfoonathan_memory.so
}
SOLIBS = ".so"
SOLIBS += ".so.*"
FILES_SOLIBSDEV = ""
INSANE_SKIP_${PN} += "dev-so"
