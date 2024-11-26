SUMMARY = "C-V2X API remoting via IVSS - IDL generated library"
DESCRIPTION = "provide telSDK C-V2X API to remote CPU via commonapi/vsomeip"
#common license
LICENSE = "MPL-2.0 & Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MPL-2.0;md5=815ca599c9df247a0c7f619bab123dad \
                    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
"

DEPENDS = "glib-2.0 commonapi3 common-api-c++-someip fastdds"

SRC_DIR = "${WORKSPACE}/cv2x/cv2x-oss-other/cv2x-remote-gen/"
SRC_URI = "file://cv2x/cv2x-oss-other/cv2x-remote-gen/ \
          "
S = "${WORKDIR}/cv2x/cv2x-oss-other/cv2x-remote-gen"

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
