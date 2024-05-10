SUMMARY = "C-V2X API remoting via IVSS - IDL generated library"
DESCRIPTION = "provide telSDK C-V2X API to remote CPU via commonapi/vsomeip"
#common license
LICENSE = "BSD-3-Clause & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

DEPENDS = "glib-2.0 commonapi3 common-api-c++-someip fastdds"

SRC_DIR = "${WORKSPACE}/cv2x/cv2x-oss-other/cv2x-remote-gen/"
SRC_URI = "file://cv2x/cv2x-oss-other/cv2x-remote-gen/ \
          "
S = "${WORKDIR}/cv2x/cv2x-oss-other/cv2x-remote-gen"

inherit pkgconfig qprebuilt cmake


EXTRA_OECMAKE = " -DUSE_CONSOLE=ON \
    -DUSE_INSTALLED_COMMONAPI=ON \
    "

FILESPATH =+ "${WORKSPACE}:"
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"

