SUMMARY = "foonathan_memory_vendor"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

PROVIDES = "foonathan_memory_vendor"
PR = "r0"

inherit cmake lib_package pkgconfig

SRCREV = "0f0775770fd1c506fa9c5ad566bd6ba59659db66"
SRC_URI = "git://github.com/foonathan/memory;protocol=https;branch=main \
    "
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_MEMORY_TOOLS=OFF \
    -DFOONATHAN_MEMORY_BUILD_TESTS=OFF \
    -DFOONATHAN_MEMORY_BUILD_EXAMPLES=OFF \
    -DFOONATHAN_MEMORY_BUILD_TOOLS=OFF \
    "

FILES:${PN} += "${datadir}/foonathan_memory/* \
               ${libdir}/foonathan_memory/cmake/* \
               ${libdir}/ibfoonathan_memory.so \
    "
do_install:append() {
    ln -sf libfoonathan_memory-0.7.3.so ${D}${libdir}/ibfoonathan_memory.so
}
SOLIBS = ".so"
SOLIBS += ".so.*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"
