DESCRIPTION = "cv2x opensource"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0"
DEPENDS = "telux-lib glib-2.0"

SRC_URI  = "file://vendor/qcom/opensource/cv2x-opensource/"
SRC_DIR = "${WORKDIR}/vendor/qcom/opensource/cv2x-opensource/"

S = "${WORKDIR}/vendor/qcom/opensource/cv2x-opensource/"

inherit cmake

FILESPATH =+ "${WORKSPACE}:"
FILES_${PN} += "${systemd_unitdir}"