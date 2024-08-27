SUMMARY = "SPLITS- IDL generated library"
DESCRIPTION = "provide SPLITS data path via fast-dds"
#common license
LICENSE = "BSD-3-Clause-Clear & Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0\
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "glib-2.0 fastdds"

SRC_DIR = "${WORKSPACE}/cv2x/cv2x-opensource/SPLITS/dds"
SRC_URI = "file://cv2x/cv2x-opensource/SPLITS/dds \
          "
S = "${WORKDIR}/cv2x/cv2x-opensource/SPLITS/dds"

inherit pkgconfig qprebuilt cmake


EXTRA_OECMAKE = " -DUSE_CONSOLE=ON \
    -DUSE_INSTALLED_COMMONAPI=ON \
    -DCMAKE_INSTALL_PREFIX=/cv2x_extra \
    "

FILESPATH =+ "${WORKSPACE}:"
FILES_SOLIBSDEV = ""

FILES:${PN} += "/cv2x_extra/lib/*"
FILES:${PN}-dev = "/cv2x_extra/include/* "
SYSROOT_DIRS += " ${bindir} "
SYSROOT_DIRS:append = "/cv2x_extra"
