SUMMARY = "SPLITS- IDL generated library"
DESCRIPTION = "provide SPLITS control path via commonapi/vsomeip"
#common license
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MPL-2.0;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS = "glib-2.0 commonapi3 common-api-c++-someip"

SRC_DIR = "${WORKSPACE}/cv2x/cv2x-oss-other/SPLITS/"
SRC_URI = "file://cv2x/cv2x-oss-other/SPLITS/ \
          "
S = "${WORKDIR}/cv2x/cv2x-oss-other/SPLITS"

inherit pkgconfig qprebuilt cmake


EXTRA_OECMAKE = " -DUSE_CONSOLE=ON \
    -DUSE_INSTALLED_COMMONAPI=ON \
    -DCMAKE_INSTALL_PREFIX=/cv2x_extra \
    "

FILESPATH =+ "${WORKSPACE}:"
FILES_SOLIBSDEV = ""
FILES:${PN} += "/cv2x_extra/lib/*"
FILES:${PN}-dev = "/cv2x_extra/include/* "

SYSROOT_DIRS:append = "/cv2x_extra"
