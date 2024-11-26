SUMMARY = "C-V2X API remoting via IVSS"
DESCRIPTION = "provide telSDK C-V2X API to remote CPU via commonapi/vsomeip"
#common license

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

DEPENDS += "telux-lib commonapi3 common-api-c++-someip fastdds cv2x-remote-gen"

FILESPATH =+ "${WORKSPACE}:"
SRC_DIR = "${WORKSPACE}/cv2x/cv2x-opensource/cv2x-remote-api"
SRC_URI = "file://${@d.getVar('SRC_DIR', True).replace('${WORKSPACE}/', '')}"

S = "${WORKDIR}/cv2x/cv2x-opensource/cv2x-remote-api"

inherit pkgconfig cmake systemd

EXTRA_OECMAKE = " \
    -DCMAKE_INSTALL_PREFIX=/cv2x_extra \
    -DTARGET=SERVER \
    -DUSE_CONSOLE=ON \
    -DUSE_INSTALLED_COMMONAPI=ON \
    -DSYS_INCLUDE=${RECIPE_SYSROOT}/cv2x_extra/include \
"


FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "${systemd_unitdir} \
                /cv2x_extra/lib/* \
                /cv2x_extra/bin/* \
"
FILES_SOLIBSDEV = ""
SYSROOT_DIR:append = "/cv2x_extra"

do_install:append() {
    rm -f ${D}/cv2x_extra/include
    rm -f ${D}/cv2x_extra/share
}
