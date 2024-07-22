SUMMARY = "C-V2X API remoting via IVSS"
DESCRIPTION = "provide telSDK C-V2X API to remote CPU via commonapi/vsomeip"
#common license

LICENSE = "BSD-3-Clause & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

DEPENDS += "telux-lib commonapi3 common-api-c++-someip fastdds cv2x-remote-gen"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/cv2x/cv2x-opensource/cv2x-remote-api"
SRC_URI = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE}/', '')}"

S = "${WORKDIR}/cv2x/cv2x-opensource/cv2x-remote-api"

inherit pkgconfig cmake systemd

EXTRA_OECMAKE = " \
    -DTARGET=SERVER \
    -DUSE_CONSOLE=ON \
    -DUSE_INSTALLED_COMMONAPI=ON \
    -DSYS_INCLUDE=${RECIPE_SYSROOT}/usr/include \
"


FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "${systemd_unitdir}"
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"

