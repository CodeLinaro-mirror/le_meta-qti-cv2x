SUMMARY = "QTI package groups for CV2X modules"
LICENSE = "BSD-3-Clause-Clear"

inherit packagegroup

# Define whether to install packagegroup-qti-telematics-cv2x-its, for ITS stacks and related packages
# Normally this is enabled for external APs only, but can also be enabled for specific targets, like sa525m
CV2X_ITS ?= "${@bb.utils.contains_any('MACHINE_FEATURES', ['external-ap', 'qti-external-ap'], "True", "False", d)}"
CV2X_ITS:sa525m = "${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], 'True', 'False',d)}"

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
    packagegroup-qti-cv2x \
    packagegroup-qti-cv2x-utils \
    ${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], '${MLPREFIX}packagegroup-qti-telematics-cv2x', '', d)} \
    ${@oe.utils.conditional('CV2X_ITS', 'True', '${MLPREFIX}packagegroup-qti-telematics-cv2x-its', '', d)} \
    '

RDEPENDS:${PN} = "\
    ${MLPREFIX}packagegroup-qti-cv2x-utils \
    ${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], '${MLPREFIX}packagegroup-qti-telematics-cv2x', '', d)} \
    "

RDEPENDS:packagegroup-qti-telematics-cv2x = "\
    cv2x-opensource \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-cv2x-remote', 'cv2x-remote-api', '', d)} \
    ${MLPREFIX}packagegroup-qti-telematics-cv2x-its \
    "

RDEPENDS:packagegroup-qti-telematics-cv2x-its = "\
    aerolink-configurations \
    "

RDEPENDS:packagegroup-qti-cv2x-utils = "\
    ${@oe.utils.conditional('CV2X_ITS', 'True', 'udpreplay', '', d)} \
    "
