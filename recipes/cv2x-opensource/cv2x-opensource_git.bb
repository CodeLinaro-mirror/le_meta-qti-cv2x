DESCRIPTION = "cv2x opensource"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0"
DEPENDS = "telux-lib glib-2.0"

SRC_URI = "file://cv2x/cv2x-opensource/"
SRC_DIR = "${WORKSPACE}/cv2x/cv2x-opensource/"
S = "${WORKDIR}/cv2x/cv2x-opensource"

inherit cmake pkgconfig

FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "${systemd_unitdir}"