DESCRIPTION = "cv2x-proxy implements data forwarding"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0"
DEPENDS = "telux-lib glib-2.0"

SRC_URI = "file://cv2x/cv2x-opensource/cv2x-proxy/"
SRC_DIR = "${WORKSPACE}/cv2x/cv2x-opensource/cv2x-proxy/"
S = "${WORKDIR}/cv2x/cv2x-opensource/cv2x-proxy/"

inherit cmake pkgconfig

FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "${systemd_unitdir}"
